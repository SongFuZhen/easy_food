-- begin EASYFOOD_SHOP
alter table EASYFOOD_SHOP add constraint FK_EASYFOOD_SHOP_ON_MANAGER foreign key (MANAGER_ID) references SEC_USER(ID)^
create index IDX_EASYFOOD_SHOP_ON_MANAGER on EASYFOOD_SHOP (MANAGER_ID)^
-- end EASYFOOD_SHOP
