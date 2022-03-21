use jukebox;
-- CREATING PODCASTEPISODE TABLE
create table PodcastEpisode
(
episodeId int primary key auto_increment,
episodeName char(50) not null,
episodeNumber int not null, 
episodeDuration char(50) not null,
episodeReleaseDate date not null,
podcastId int not null,
foreign key (podcastId) references Podcast(podcastId)
);
-- ALTERING PODCASTEPISODE TABLE
alter table PodcastEpisode auto_increment=100;
-- INSERT VALUES IN PODCASTEPISODE TABLE
insert into PodcastEpisode(episodeName,episodeNumber ,episodeDuration , episodeReleaseDate ,podcastId) values('Steve Jobs:A perfect CEO',8,'15:45','2016-04-02',1000);
insert into PodcastEpisode(episodeName,episodeNumber ,episodeDuration , episodeReleaseDate ,podcastId) values('Lisa Brennan:jobs',10,'30:60','2019-07-25',1001);
insert into PodcastEpisode(episodeName,episodeNumber ,episodeDuration , episodeReleaseDate ,podcastId) values('My Journey',12,'45:15','2020-09-18',1002);		
select last_insert_id();
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CREATING PODCASST TABLE
create table Podcast
(
podcastId int primary key auto_increment,
podcastName char(50) not null,
narratorId int not null,
genreId int not null,
celebrityId int not null,
foreign key (narratorId) references Narrator(narratorId),
foreign key (genreId) references PodcastGenre(genreId),
foreign key (celebrityId) references Celebrity(celebrityId)
);
-- ALTERING PODCAST TABLE
alter table Podcast auto_increment=1000;
-- INSERT VALUES INTO PODCAST TABLE
insert into Podcast(podcastName,narratorId,genreId,celebrityId) values('gaana',10000,100000,1000000);
insert into Podcast(podcastName ,narratorId , genreId , celebrityId ) values('saavan',10001,100001,1000001);
insert into Podcast(podcastName ,narratorId , genreId , celebrityId ) values('NDTV',10002,100002,1000002);		
select last_insert_id();
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CREATING NARRATOR TABBLE
create table Narrator
(
narratorId int primary key auto_increment,
narratorName char(50) not null
);
-- ALTERING NARRATOR TABLE
alter table Narrator auto_increment=10000;
-- INSERTING VALUES IN NARRATOR TABLE
insert into Narrator(narratorname) values('Harvard');
insert into Narrator(narratorname) values('john,OLeary');
insert into Narrator(narratorname) values('Self');		
select last_insert_id();
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CREATING PODCASTGENRE TABLE
create table PodcastGenre
(
genreId int primary key auto_increment,
genreName char(50) not null
);
-- ALTERING TABLE
alter table PodcastGenre auto_increment=100000;
-- INSERTING VALUES IN PODCASTGENRE
insert into Podcastgenre(genreName) values('HBR idea cast');
insert into Podcastgenre(genreName) values('Live Inspired');
insert into Podcastgenre(genreName) values('Autobiography');		
select last_insert_id();
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CREATING TABLE CELEBRITY
create table Celebrity 
(
celebrityId int primary key auto_increment,
celebrityName char(50) not null
);
-- ALTERING TABLE
alter table Celebrity auto_increment=1000000;

-- INSERTING VALUES IN CELEBRITY TABLE
insert into Celebrity(celebrityName) values('Jazz');
insert into Celebrity(celebrityName) values('Blue');
insert into Celebrity(celebrityName) values('Brown');		
select last_insert_id();
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CREATING VIEW
create view podcastpv as select podcastEpisode.episodeName,episodeNumber,episodeDuration , podcastgenre.genreName , narrator.narratorName ,  celebrity.celebrityName , podcast.podcastName 
from  PodcastEpisode  join Podcast   on podcast.podcastId = podcastEpisode.podcastId
join  Narrator  on podcast.narratorId = narrator.narratorId
join  PodcastGenre  on  podcast.genreId = podcastgenre.genreId
join  Celebrity  on podcast.celebrityId = celebrity.celebrityId;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- SELECT STATEMENTS
select * from PodcastEpisode;
select * from Podcast;
select * from Narrator;
select * from PodcastGenre;
select * from Celebrity;
select * from podcastpv;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- DESCRIBE STATEMENTS
describe PodcastEpisode;
describe Podcast;
describe Narrator;
describe PodcastGenre;
describe Celebrity;
describe podcastpv;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 