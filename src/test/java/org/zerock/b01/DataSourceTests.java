package org.zerock.b01;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@SpringBootTest
public class DataSourceTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws SQLException {
        @Cleanup Connection conn = dataSource.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement("select now(),?");
        stmt.setString(1,"asd");
        @Cleanup ResultSet rs = stmt.executeQuery();
        rs.next();
        log.info(rs.getString(1));
        Assertions.assertNotNull(conn);
    }
}
