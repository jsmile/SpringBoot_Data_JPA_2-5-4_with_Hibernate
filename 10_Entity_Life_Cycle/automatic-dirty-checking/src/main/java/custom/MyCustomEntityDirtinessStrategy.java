package custom;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.Session;
import org.hibernate.persister.entity.EntityPersister;

public class MyCustomEntityDirtinessStrategy implements CustomEntityDirtinessStrategy {

	public boolean canDirtyCheck(Object arg0, EntityPersister arg1, Session arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void findDirty(Object arg0, EntityPersister arg1, Session arg2, DirtyCheckContext arg3) {
		// TODO Auto-generated method stub
		
	}

	public boolean isDirty(Object arg0, EntityPersister arg1, Session arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void resetDirty(Object arg0, EntityPersister arg1, Session arg2) {
		// TODO Auto-generated method stub
		
	}



}
