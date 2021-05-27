import java.security.Permission;

public class BadSecurityManager extends SecurityManager {
	@Override
	public void checkPermission(Permission perm) {
		return;
	}
}
