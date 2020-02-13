create table EASYFOOD_ORDER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NR varchar(255) not null,
    SHOP_ID varchar(32) not null,
    USER_ID varchar(32) not null,
    ORDER_DATE date not null,
    TOTAL_PRICE decimal(19, 2),
    --
    primary key (ID)
);