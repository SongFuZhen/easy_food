alter table EASYFOOD_ORDER add constraint FK_EASYFOOD_ORDER_ON_SHOP foreign key (SHOP_ID) references EASYFOOD_SHOP(ID);
alter table EASYFOOD_ORDER add constraint FK_EASYFOOD_ORDER_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_EASYFOOD_ORDER_ON_SHOP on EASYFOOD_ORDER (SHOP_ID);
create index IDX_EASYFOOD_ORDER_ON_USER on EASYFOOD_ORDER (USER_ID);
