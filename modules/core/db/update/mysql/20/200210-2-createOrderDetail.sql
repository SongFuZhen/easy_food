alter table EASYFOOD_ORDER_DETAIL add constraint FK_EASYFOOD_ORDER_DETAIL_ON_ORDER foreign key (ORDER_ID) references EASYFOOD_ORDER(ID);
alter table EASYFOOD_ORDER_DETAIL add constraint FK_EASYFOOD_ORDER_DETAIL_ON_SHOP foreign key (SHOP_ID) references EASYFOOD_SHOP(ID);
alter table EASYFOOD_ORDER_DETAIL add constraint FK_EASYFOOD_ORDER_DETAIL_ON_COOKBOOK foreign key (COOKBOOK_ID) references EASYFOOD_COOKBOOK(ID);
create index IDX_EASYFOOD_ORDER_DETAIL_ON_ORDER on EASYFOOD_ORDER_DETAIL (ORDER_ID);
create index IDX_EASYFOOD_ORDER_DETAIL_ON_SHOP on EASYFOOD_ORDER_DETAIL (SHOP_ID);
create index IDX_EASYFOOD_ORDER_DETAIL_ON_COOKBOOK on EASYFOOD_ORDER_DETAIL (COOKBOOK_ID);
