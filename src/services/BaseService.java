package services;

import java.io.File;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class BaseService {
	
	@Context
	ServletContext ctx;

	protected String getContext() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "json"
				+ File.separator);
	}
}
