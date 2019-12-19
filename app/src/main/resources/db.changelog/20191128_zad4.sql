create table section(
    id int not null primary key,
    name varchar not null
);

create table category(
    id int not null primary key,
    section_id int not null,
    name varchar not null,
    foreign key (section_id) references section (id)
);

create table auction(
    id bigint not null primary key,
    category_id int not null,
    title varchar not null,
    description varchar not null,
    price float not null,
    owner_id int not null,
    --order_by int not null,
    foreign key (category_id) references category (id),
    foreign key (owner_id) references profile (id)
);

create table photo(
    id bigint not null primary key,
    auction_id int not null,
    order_by int not null,
    url varchar not null,
    foreign key (auction_id) references auction (id)
);

create table parameter(
    id int not null primary key,
    name varchar not null
);

create table auction_parameter(
    auction_id int not null,
    parameter_id int not null,
    value varchar not null,
    primary key (auction_id, parameter_id),
    foreign key (auction_id) references auction (id),
    foreign key (parameter_id) references parameter (id)
);