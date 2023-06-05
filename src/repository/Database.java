package repository;

class Database {
    private static Database instance;
    
    private Database() {}
    
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}