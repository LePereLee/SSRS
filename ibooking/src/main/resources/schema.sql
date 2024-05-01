drop table if exists tbl_student;
create table tbl_student
(
    id       int         not null auto_increment,
    stuNum   varchar(16) not null,
    name     varchar(16) not null,
    password varchar(16) not null,
    primary key (id),
    unique (stuNum)
);

drop table if exists tbl_studyroom;
create table tbl_study_room
(
    id           int         not null auto_increment,
    buildingNum  varchar(16) not null,
    classRoomNum varchar(16) not null,
    primary key (id)
);

drop table if exists tbl_seat;
create table tbl_seat
(
    id          int not null auto_increment,
    studyRoomId int not null,
    primary key (id, studyRoomId)
);

drop table if exists tbl_booking_xxx;
create table tbl_booking_xxx
(
    id            int not null auto_increment,
    seatId        int not null,
    bookingPeriod int not null,
    stuId         int not null,
    primary key (id)
);