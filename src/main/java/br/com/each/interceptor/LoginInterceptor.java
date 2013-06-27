package br.com.each.interceptor;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.each.model.usuario.UserSession;

@Intercepts
public class LoginInterceptor implements Interceptor {

	private Result result;
	private UserSession userSession;

	public LoginInterceptor(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	public boolean accepts(ResourceMethod method) {
		return false; // !(method.getMethod().isAnnotationPresent(Public.class) ||
						// method.getResource().getType().isAnnotationPresent(Public.class));
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) {
		if (userSession.isLogado()) {
			stack.next(method, resourceInstance);
		} else {
			result.notFound();
		}
	}

}