package Authentication;

public interface Authentication {

  void login(String email, String password);
  void signup(String username, String password, String email);

}
