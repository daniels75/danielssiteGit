package org.daniels.projects.site.pages.address;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
//import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.appfuse.service.GenericManager;
import org.daniels.projects.site.entities.Address;
import org.daniels.projects.site.entities.Person;
import org.daniels.projects.site.pages.Index;
import org.daniels.projects.site.pages.PersonList;
import org.daniels.projects.site.pages.Tutorial;
import org.hibernate.Session;
import org.slf4j.Logger;

public class CreateAddress {


	@InjectPage
	private Index index;

    @Inject
    @Service("addressManager")
    private GenericManager<Address, Long> addressManager;
    
    
	
    @Property(write = false)
    @Persist
    private Address address;


    /**
     * Allows setting person object from another class (i.e. PersonList)
     *
     * @param person an initialized instance
     */
    public void setPerson(Address address) {
        this.address = address;
    }
	
    void beginRender() {
        if (address == null) {
            address = new Address();
        }
    }

    void onActivate(EventContext ec) {
        if (ec.getCount() == 0) {
            address = null;
        }
        else if (ec.getCount() == 1) {
            address = addressManager.get(ec.get(Long.class, 0));
        }
        else {
            throw new IllegalStateException("Invalid Request");
        }
    }

    Long onPassivate() {
        return   address != null ? address.getId() : null;
    }

    void onPrepare() {
        if (address == null) {
            address = new Address();
        }
    }
    private boolean cancel;
    private boolean delete;
    
    @Inject
    private Logger log;
    
    @InjectPage
    private Tutorial tutorial;
    
    Object onSuccess() {
        if (delete) return onDelete();
        if (cancel) return onCancel();

        log.debug("Saving person..." + address);

        boolean isNew = (address.getId() == null);

        addressManager.save(address);


        if (isNew) {
            return tutorial;
        } else {
            return this;
        }
    }
    
    
    Object onDelete() {
    	addressManager.remove(address.getId());
        return tutorial;
    }

    Object onCancel() {
        return tutorial;
    }
    
	
}
