package link.softbond.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import link.softbond.DataSourceConfig;

@Service
public class DBService {
    
    private final DataSourceConfig dataSourceConfig;

    @Autowired
    public DBService(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public void cambiar(String driverClassName, String url, String username, String password) {
        dataSourceConfig.setDataSourceProperties(driverClassName, url, username, password);
    }
    
    public void seleccionar(String database) {
    	String driverClassName = "com.mysql.cj.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/"+database+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    	String username = "root";
    	String password = "";
        dataSourceConfig.setDataSourceProperties(driverClassName, url, username, password);
        dataSourceConfig.updateDataSource();
    }
    
    public DataSource getDataSourceCurrent() {
    	return dataSourceConfig.getDataSource();
    }
    
    
}