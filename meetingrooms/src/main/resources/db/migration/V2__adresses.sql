create table addresses (id bigint not null auto_increment,
                        city varchar(255),
                        street varchar(255),
                        house_number int,
                        emp_id bigint,
                        primary key (id),
                        CONSTRAINT `fk_address_emp`
                            foreign key(emp_id)
                                references employees (id) ON DELETE CASCADE ON UPDATE RESTRICT)
