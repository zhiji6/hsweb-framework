package org.hswebframework.web.database.manager;

import org.hswebframework.web.database.manager.meta.ObjectMetadata;
import org.hswebframework.web.datasource.DynamicDataSource;

import java.util.List;
import java.util.Map;

/**
 * @author zhouhao
 */
public interface DatabaseManagerService {

    /**
     * 开启一个指定数据源的事务,并返回事务ID,在其他操作的时候,使用事务ID共享同一个事务
     *
     * @param datasourceId 数据源ID {@link DynamicDataSource#getId()}
     * @return 事务ID
     */
    String newTransaction(String datasourceId);

    /**
     * 对默认数据源开启事务,并返回事务ID,在其他操作的时候,使用事务ID共享同一个事务
     *
     * @return 事务ID
     */
    String newTransaction();

    /**
     * 提交事务
     *
     * @param transactionId 事务ID
     */
    void commit(String transactionId);

    /**
     * 回滚事务
     *
     * @param transactionId 事务ID
     */
    void rollback(String transactionId);

    List<SqlExecuteResult> execute(String transactionId, SqlExecuteRequest request);

    Map<ObjectMetadata.ObjectType, List<ObjectMetadata>> getMetas(String datasourceId);

}
