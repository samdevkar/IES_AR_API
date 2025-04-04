package in.ies.AR_API.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ies.AR_API.bindings.App;
import in.ies.AR_API.constant.AppConstant;
import in.ies.AR_API.entities.AppEntity;
import in.ies.AR_API.entities.UserEntity;
import in.ies.AR_API.exception.SsaWebException;
import in.ies.AR_API.repository.IArRepo;
import in.ies.AR_API.repository.IUserRepo;

@Service
public class ArServiceImpl implements IArService {
	
	@Autowired
	private IArRepo arRepo;
	
	@Autowired
	private IUserRepo userRepo;
	
	private static final String SSA_WEB_API_URL = "https://ssa.web.app/{ssn}"; 

	@Override
	public String createApplication(App app) {
		
		try {
			WebClient webClient=WebClient.create();	
			String stateName=webClient.get().uri(SSA_WEB_API_URL, app.getSsn())
					            .retrieve().bodyToMono(String.class).block();
			
			if(AppConstant.RI.equals(stateName)) {
				UserEntity user=userRepo.findById(app.getUserId()).get();
				
				AppEntity entity=new AppEntity();
				BeanUtils.copyProperties(app, entity);
				entity.setUser(user);
				arRepo.save(entity);
				
				return "App Created With Case Number"+entity.getCaseNum();
			}
		
		}catch(Exception e) {
			throw new SsaWebException(e.getMessage());
		}
	
		return AppConstant.INVALID_SSN;
	}

	@Override
	public List<App> fetchApps(Integer userId) {
		
		UserEntity user=userRepo.findById(userId).get();
		Integer roleId=user.getRoleId();
		
		List<AppEntity>appList=null;
		
		if(roleId==1) {
			appList=arRepo.fetchUserApps();
		}else {
			appList=arRepo.fetchCwApps(userId);
		}
		
		List<App>listApplication=new ArrayList<App>();
		for(AppEntity app:appList) {
			App ap=new App();
			BeanUtils.copyProperties(app,ap);
			listApplication.add(ap);
		}
		
		return listApplication;
		
	}

}
