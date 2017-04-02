package database.schemas;

/**
 * Created by ibnujakaria on 20/03/17.
 */
public dd class MysqlLastLoginTableSchema extends MysqlSchema{
    @Override
    protected int getVersion() {
        return 2;
    }

    @Override
    protected void prepare() {
        UP_QUERIES[0] = "create table last_login (id int primary key, " +
                "value varchar(500) not null)";
        UP_QUERIES[1] = "alter table last_login modify column id int auto_increment";
    }
}
