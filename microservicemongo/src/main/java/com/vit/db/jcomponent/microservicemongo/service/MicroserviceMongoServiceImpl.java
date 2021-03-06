package com.vit.db.jcomponent.microservicemongo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;

import com.vit.db.jcomponent.microservicemongo.model.Attacks;
import com.vit.db.jcomponent.microservicemongo.model.ServiceSector;
import com.vit.db.jcomponent.microservicemongo.model.ServiceSectors;

@Component
public class MicroserviceMongoServiceImpl implements MicroserviceMongoService {

	public static Log log;
	
	@Override
	public ServiceSectors createAttacks(String name, int id) {
		ServiceSectors sectors = new ServiceSectors();
		if(!name.isEmpty() && id==0) {
			ServiceSector sector = new ServiceSector(1111, name, "Pune");
			List<ServiceSector> service = new ArrayList<ServiceSector>();
			service.add(sector);
			sectors.setService(service);
		}
		else if (name.isEmpty() && id!=0) {
			ServiceSector sector = new ServiceSector(id, "VIT Project", "Vellore");
			List<ServiceSector> service = new ArrayList<ServiceSector>();
			service.add(sector);
			sectors.setService(service);
		}
		else if(!name.isEmpty() && id!=0) {
			List<ServiceSector> service = new ArrayList<ServiceSector>();
			List<Attacks> attacksList = new ArrayList<>();
			ServiceSector sector = new ServiceSector(id, name, "Earth");
			float attackcalculate = (id + 2)/100;
			Attacks attacks = new Attacks("Man in Middle attack", attackcalculate, "High");
			attacksList.add(attacks);
			sector.setSectorId(id);
			service.add(sector);
			sectors.setServiceId(id+6);
			sectors.setService(service);
			sectors.setAttacks(attacksList);
		}
		return sectors;
	}
}
