package org.daniels.projects.site.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.FormValidationControl;
import org.apache.tapestry5.TrackableComponentEventCallback;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Cached;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.internal.services.StringValueEncoder;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.appfuse.model.Role;
import org.appfuse.model.User;
import org.appfuse.service.RoleManager;
import org.daniels.projects.site.constants.SiteEventConstants;
import org.daniels.projects.site.services.CountryService;
import org.daniels.projects.site.services.impl.RoleEncoder;
import org.slf4j.Logger;

/**
 * Generic form for User manipulation
 *
 * @author Serge Eby
 * @version $Id: UserForm.java 5 2008-08-30 09:59:21Z serge.eby $
 */
@SupportsInformalParameters
public class UserForm implements ClientElement, FormValidationControl {

    @Inject
    private Logger logger;

    @Parameter(required = true, autoconnect = true)
    @Property
    private User user;

    @Parameter("true")
    @Property
    private boolean signup;

    @Parameter(value = "message:button.save", defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String submitLabel;

    @Parameter(allowNull = true)
    private String from;

    @Parameter(value = "true")
    @Property
    private boolean cookieLogin;

    @Property
    @Parameter
    private String heading;

    @Parameter(allowNull = true)
    @Property
    private List<Role> selectedRoles;

    @Property(write = false)
    private String infoMessage;

    @Inject
    private ComponentResources resources;

    @Inject
    private Messages messages;

    @Inject
    private JavaScriptSupport jsSupport;

    @Inject
    private RoleManager roleManager;

    @Inject
    private CountryService countryService;


    @SuppressWarnings("unchecked")
    @Environmental
    private TrackableComponentEventCallback eventCallback;

    @Component(parameters = "validatationId=componentResources.id",
            publishParameters = "clientValidation,autofocus,zone")
    private Form form;

    public Form getForm() {
        return form;
    }

    boolean onValidateFromForm() {
        resources.triggerEvent(SiteEventConstants.VALIDATE_PASSWORD, null, null);
        return true;
    }

    public String getClientId() {
        return form.getClientId();
    }

    public void clearErrors() {
        form.clearErrors();
    }

    public boolean getHasErrors() {
        return form.getHasErrors();
    }

    public boolean isValid() {
        return form.isValid();
    }

    public void recordError(Field field, String errorMessage) {
        form.recordError(field, errorMessage);
    }

    public void recordError(String errorMessage) {
        form.recordError(errorMessage);
    }

    @Cached
    public Map<String, String> getCountryModel() {
        return countryService.getAvailableCountries();
    }

    public ValueEncoder<String> getCountryEncoder() {
        return new StringValueEncoder();
    }

    @Cached
    public List<Role> getRoleModel() {
        return roleManager.getAll();
    }

    public ValueEncoder getRoleEncoder() {
        return new RoleEncoder(roleManager);
    }

    public List<String> getUserRoles() {
        List<String> userRoles = new ArrayList<String>();
        if (user != null) {
            for (Role r : user.getRoles()) {
                userRoles.add(r.getName());
            }
        }
        return userRoles;
    }

    public boolean isUserVersionNull() {
        return (user == null || user.getVersion() == null);
    }

    public boolean isFromList() {
        return "list".equals(from);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isUserPersisted() {
        return user != null && user.getId() != null;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public String getConfirmDeletion() {
        return messages.format("delete.confirm", "user: " + user.getUsername());
    }
}
