package in.ies.AR_API.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ies.AR_API.bindings.App;
import in.ies.AR_API.service.IArService;

@RestController
public class ArRestController {
	
	private IArService iArService;
	
	@PostMapping("/app")
	public ResponseEntity<String>createApp(App app){
		return new ResponseEntity<String>("App Created",HttpStatus.CREATED);
	}
	
	@GetMapping("/apps/{userId}")
	public ResponseEntity<List<App>>fetchAppList(@PathVariable Integer userId){
		List<App>list=iArService.fetchApps(userId);
		return new ResponseEntity<List<App>>(list,HttpStatus.OK);
	}

}
