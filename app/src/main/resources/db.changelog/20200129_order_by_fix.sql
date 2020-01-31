alter table auction drop column order_by;
alter table photo add column order_by int;
alter table photo alter column order_by set not null;