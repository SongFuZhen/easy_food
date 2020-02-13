create table EASYFOOD_COOKBOOK (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    SHOP_ID varchar(32) not null,
    NAME varchar(255) not null,
    PRICE decimal(19, 2) not null,
    INGREDIENTS varchar(255),
    REMARK varchar(255),
    --
    primary key (ID)
);