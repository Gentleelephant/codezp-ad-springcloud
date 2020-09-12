package club.codezp.mysql.listener;

import club.codezp.mysql.dto.BinlogRowData;

/**
 *
 */
public interface Ilistener {

    void register();

    void onEvent(BinlogRowData eventData);
}
