package in.ies.AR_API.service;

import java.util.List;

import in.ies.AR_API.bindings.App;

public interface IArService {
	
	public String createApplication(App app);
	
	public List<App>fetchApps(Integer userId);

}
