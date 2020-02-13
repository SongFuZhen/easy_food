create table EASYFOOD_ORDER_DETAIL (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(32) not null,
    SHOP_ID varchar(32),
    COOKBOOK_ID varchar(32),
    QUANTITY integer not null,
    TOTAL_PRICE decimal(19, 2),
    --
    primary key (ID)
);