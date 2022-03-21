create database Jukebox;
use jukeBox;
drop database jukebox;

create table song
(songid int primary key auto_increment,
songname char(20) not null,
duration char(10),
artistid int,
albumid int,
genreid int,
--  foreign keys to be implemented 
foreign key (artistid) references artist (artistid),
foreign key (albumid) references album(albumid),
foreign key (genreId) references genre(genreid)
);

Alter table song auto_increment = 1001;

create table artist( artistid int primary key auto_increment, artistname char(20));
alter table artist auto_increment = 01;
create table album(albumid int primary key auto_increment, albumname char(20),releaseyear char(4));
alter table album auto_increment = 101;
create table genre(genreid int primary key auto_increment,genrename char(20));
alter table genre auto_increment = 1;
-- Catalogue view
create view Catalogue as select song.songname,song.duration,artist.artistname,album.albumname,genre.genrename 
from song join artist on song.artistid =artist.artistid join album on song.albumid = album.albumid join genre on song.genreid = genre.genreid;



-- data feed for the respective tables
insert into artist values (artistid,"Eminem");
insert into artist values (artistid,"TravisScott");

insert into album values(albumid,"Halla","2013");
insert into album values(albumid,"Macahdo","2015");

insert into genre values(genreid,'Blue');
insert into genre values(genreid,'Jazz');

insert into song values(songid,"Rap God","05:57",01,101,1);
insert into song values(songid,"Antitide","06:30",02,102,2);


-- re-check of tables 
select * from song;
select * from artist;
select * from album;
select * from genre;
select * from Catalogue;

-- describe tables
describe song;
describe artist;
describe album;
describe genre;
describe Catalogue;
 
