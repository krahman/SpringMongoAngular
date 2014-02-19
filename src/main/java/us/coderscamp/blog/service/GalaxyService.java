package us.coderscamp.blog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import us.coderscamp.blog.model.Galaxy;

@Repository
public class GalaxyService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "galaxy";
	
	public void addGalaxy(Galaxy galaxy){
		if (!mongoTemplate.collectionExists(Galaxy.class)){
			mongoTemplate.createCollection(Galaxy.class);
		}
		galaxy.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(galaxy, COLLECTION_NAME);
	}
	
	public List<Galaxy> listGalaxy(){
		return mongoTemplate.findAll(Galaxy.class, COLLECTION_NAME);
	} 

	public void deleteGalaxy(Galaxy galaxy){
		mongoTemplate.remove(galaxy, COLLECTION_NAME);
	}
	
	public void updateGalaxy(Galaxy galaxy){
		mongoTemplate.insert(galaxy, COLLECTION_NAME);
	}
}
