package com.unsa.PhotoSharing.Recommendation;

import java.util.ArrayList;
import java.util.List;


import weka.classifiers.lazy.IBk;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.neighboursearch.*;

public class UserRecommendation 
{
	static UserData userData;
	int attributesSize;
	static Instance searchInstance;
	static Instances instances;
	static LinearNNSearch knn;
	static int RECOMMEND = 10;
	List<Integer> recommendations;
	
	public List<Integer> getRecommended()
	{
		return recommendations;
	}
	public UserRecommendation(Integer instance)
	{
		userData = new UserData();
		FastVector attributes = createAttributes();
		instances = createLearningDataSet(attributes);		
		knn = new LinearNNSearch(instances);
		setInstance(instance.intValue());
	}
	
	public void setInstance(int userId)
	{
		int instanceNumber = userData.getUsersId().indexOf(userId);
		searchInstance = instances.instance(instanceNumber);
		System.out.println("recomendando para " + instanceNumber);
		Instances nearestInstances;
		try {
			nearestInstances = knn.kNearestNeighbours(searchInstance, RECOMMEND);
			System.out.println(nearestInstances);
			System.out.println("---" + nearestInstances.numInstances());
			recommendations = getRecommendations(nearestInstances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public List<Integer> getRecommendations(Instances i)
	{
		List<Integer> result = new ArrayList<>();
		
		for (int users = 0; users < userData.getUsersId().size(); users++)
		{
			Instance tmp = instances.instance(users);
			for (int j = 0; j < RECOMMEND; j++)
			{
				Instance guessed = i.instance(j);
				boolean add = true;
				for(int it = 0; it < guessed.numValues(); it++)
				{
					if (tmp.value(it) != guessed.value(it)) add = false;
				}
				if(add)
				{
					System.out.println("adivinado: " + guessed);
					System.out.println("data     : " + tmp);
					
					result.add(userData.getUsersId().get(users));
					break;
				}
			}
		}
		
		System.out.println("RESULTS " + result);
		return result;
	}
	
	private FastVector createAttributes() 
	{
		attributesSize = userData.getUsersId().size();
		FastVector allAttributes = new FastVector(attributesSize);
		for (Integer i : userData.getUsersId())
			allAttributes.addElement(new Attribute("item" + i));
			
		return allAttributes;
	}
	
	private Instances createLearningDataSet(FastVector allAttributes) 
	{
		Instances trainingDataSet = new Instances("UserRecommendation", allAttributes, attributesSize);
		//trainingDataSet.setClassIndex(0);
		
		for(int i = 0; i < attributesSize; i++)
			addInstance(trainingDataSet, userData.getIsFriend().get(i));
		
		System.out.println(trainingDataSet);
		return trainingDataSet;

	}
	private void addInstance(Instances trainingDataSet, List<Boolean> friendsList) 
	{
		Instance instance = new Instance(friendsList.size());
		instance.setDataset(trainingDataSet);
		
		for (int j = 0; j < friendsList.size(); j++)
		{
			double value = 0;
			if (friendsList.get(j)) value = 1;
			
			instance.setValue(j, value);
		}	
		
		trainingDataSet.add(instance);
	}
	
	
}