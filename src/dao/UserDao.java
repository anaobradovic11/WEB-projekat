/*
 * package dao;
 * 
 * import java.io.BufferedReader; import java.io.File; import
 * java.io.FileReader; import java.util.Collection; import java.util.HashMap;
 * import java.util.StringTokenizer;
 * 
 * import beans.Gender; import beans.User; import beans.UserRole;
 * 
 * public class UserDao extends GenericDao<String, User, UserDao> {
 * 
 * private HashMap<String, User> users = new HashMap<String, User>();
 * 
 * @Override protected String getPath() { // TODO Auto-generated method stub
 * return ""; }
 * 
 * @Override protected String getKey(User entity) { // TODO Auto-generated
 * method stub return entity.getUsername(); }
 * 
 * @Override protected void RemoveAllReference(User entity) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * public UserDao() {
 * 
 * }
 * 
 * 
 * public UserDao(String contextPath) { loadProducts(contextPath); }
 * 
 *//***
	 * Vra�a sve proizvode.
	 * 
	 * @return
	 */
/*
 * public Collection<User> findAll() { return users.values(); }
 * 
 *//***
	 * Vraca proizvod na osnovu njegovog id-a.
	 * 
	 * @return Proizvod sa id-em ako postoji, u suprotnom null
	 */
/*
 * public User findUser(String id) { return users.containsKey(id) ?
 * users.get(id) : null; }
 * 
 *//***
	 * Dodaje proizvod u mapu proizvoda. Id novog proizvoda �e biti postavljen na
	 * maxPostojeciId + 1.
	 * 
	 * @param product
	 *//*
		 * public User save(User user) { Integer maxId = -1; for (String id :
		 * users.keySet()) { int idNum =Integer.parseInt(id); if (idNum > maxId) { maxId
		 * = idNum; } } maxId++; users.setId(maxId.toString());
		 * 
		 * user.setUsername(user.getUsername()); users.put(user.getUsername(), user);
		 * return user; }
		 * 
		 * public User update(String id, User user) { User userToUpdate =
		 * this.findUser(id); if(userToUpdate == null) { return this.save(user); }
		 * userToUpdate.setName(user.getName());
		 * userToUpdate.setSurname(user.getSurname()); return userToUpdate; }
		 * 
		 * public void delete(String id) { this.users.remove(id); }
		 * 
		 * private void loadProducts(String contextPath) {
		 * 
		 * BufferedReader in = null; try { File file = new File(contextPath +
		 * "/users.txt"); System.out.println(file.getCanonicalPath()); in = new
		 * BufferedReader(new FileReader(file)); String line, id = "", name = "",
		 * surname = "", dozvola = ""; StringTokenizer st; while ((line = in.readLine())
		 * != null) { line = line.trim(); if (line.equals("") || line.indexOf('#') == 0)
		 * continue; st = new StringTokenizer(line, ";"); while (st.hasMoreTokens()) {
		 * id = st.nextToken().trim(); name = st.nextToken().trim(); surname =
		 * st.nextToken().trim(); dozvola = st.nextToken().trim();
		 * System.out.println(dozvola); } users.put(id, new User(id, name, surname,
		 * Boolean.parseBoolean(dozvola))); } } catch (Exception e) {
		 * e.printStackTrace(); } finally { if ( in != null ) { try { in.close(); }
		 * catch (Exception e) { } } }
		 * 
		 * }
		 * 
		 * }
		 */
