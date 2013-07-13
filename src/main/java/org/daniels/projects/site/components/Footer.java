package org.daniels.projects.site.components;


/**
 * Footer component
 *
 * @author Serge Eby
 */
public class Footer {

//    @Inject
//    private SecurityContext securityContext;

    public boolean isLoggedIn() {
       // return securityContext.isLoggedIn();
        return false;
    }

    public String getUsername() {
       // return securityContext.getUsername();
        return "none";
    }

}
