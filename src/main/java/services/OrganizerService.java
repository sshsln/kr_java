package services;

import model.Organizer;
import services.db.OrgDBService;

public class OrganizerService {
    public String saveNewOrg(Organizer organizer) {
        OrgDBService orgDBService = new OrgDBService();
        HashService hashService = new HashService();
        if (isLoginUnique(organizer.getLogin())) {
            organizer.setPassword(hashService.createHash(organizer.getPassword()));
            orgDBService.registrationOrg(organizer);
            LoginService loginService = new LoginService();
            String session = loginService.createSession(organizer.getLogin());
            return session;
        } else {
            return "Логин уже занят";
        }
    }

    public boolean isLoginUnique(String login) {
        OrgDBService orgDBService = new OrgDBService();
        return orgDBService.isLoginUnique(login);
    }


}
