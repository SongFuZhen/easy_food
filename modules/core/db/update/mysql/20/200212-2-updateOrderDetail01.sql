alter table EASYFOOD_ORDER_DETAIL change column ORDER_ID ORDER_ID__U25233 varchar(32)^
alter table EASYFOOD_ORDER_DETAIL drop foreign key FK_EASYFOOD_ORDER_DETAIL_ON_ORDER;
drop index IDX_EASYFOOD_ORDER_DETAIL_ON_ORDER on EASYFOOD_ORDER_DETAIL ;
alter table EASYFOOD_ORDER_DETAIL add column ORDER_NR varchar(255) ^
update EASYFOOD_ORDER_DETAIL set ORDER_NR = '' where ORDER_NR is null ;
alter table EASYFOOD_ORDER_DETAIL modify column ORDER_NR varchar(255) not null ;
