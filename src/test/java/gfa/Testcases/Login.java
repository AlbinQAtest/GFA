package gfa.Testcases;

import org.testng.annotations.Test;

import GoldenFalcon.gfaTestComponents.Base;

public class Login extends Base {
	
@Test
	public void  login_verification ()
	{
		login.loginAction("admin","Staging@GFA#");
	}
}
