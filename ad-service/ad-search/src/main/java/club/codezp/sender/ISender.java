package club.codezp.sender;


import club.codezp.mysql.dto.MySqlRowData;

/**
 *
 */
public interface ISender {

    void sender(MySqlRowData rowData);
}
