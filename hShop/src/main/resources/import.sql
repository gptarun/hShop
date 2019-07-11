INSERT INTO public.department(dep_id, department) VALUES (1000,'Admin');
INSERT INTO public.role(role_id, role_name) VALUES (1000, 'Admin');

INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (1, 'EMR');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (2, 'Settings');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (3, 'Shift Management');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (4, 'Billing & Payments');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (5, 'Nurses Desk');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (6, 'Pharmacy');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (7, 'Clerking');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (8, 'Laboratory');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (9, 'Radiology');
INSERT INTO public.parent_module(parent_module_id, module_name) VALUES (10, 'Reports');


INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (1, 'Patient Registration', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (2, 'Edit Patient Details', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (3, 'Record Visit', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (4, 'Patient Category Management', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (5, 'Edit Scheme Details', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (6, 'Patient Admission', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (7, 'Ward Transfer', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (8, 'Coding And Indexing', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (9, 'Appointment Booking', '1');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (10, 'User Manager', '2');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (11, 'Role Manager', '2');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (12, 'Seed Data Setup', '2');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (13, 'Global Setting', '2');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (14, 'Batch Uploads', '2');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (15, 'Location Setting', '2');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (16, 'Password Reset', '2');
INSERT INTO public.module(module_id, module_name, parent_module_id) VALUES (17, 'Drug Register', '6');

insert into role_module (module_id, role_id, role_module_id) values (1,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (2,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (3,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (4,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (5,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (6,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (7,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (8,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (9,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (10,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (11,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (12,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (13,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (14,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (15,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (16,1000,nextval('role_module_seq'));
insert into role_module (module_id, role_id, role_module_id) values (17,1000,nextval('role_module_seq'));
