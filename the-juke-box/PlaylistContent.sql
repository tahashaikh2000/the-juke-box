use jukebox;
------------------------------------------------------------------------------------------------------------------------------------------------------
-- PLAYLIST TABLE
create table playlist
(
playlistid int primary key auto_increment,
playlistname char(30)
);
alter table playlist auto_increment=2000;
insert into playlist (playlistname) values('MyDownload');
insert into playlist(playlistname)values('Classic');
select * from playlist;
describe playlist;
drop table playlist;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- PLAYLISTCONTENT TABLE
create table playlistcontent
(
contentid int primary key auto_increment,
playlistduration char(30),
playlistid int,
trackid int,
foreign key(playlistid)references playlist(playlistid)) ;
alter table playlistcontent auto_increment=00001;
 insert into playlistcontent(playlistduration,playlistid,trackid)values('30:40:64',2001,1014),
('45:35:36',2001,1003);
select *from playlistcontent;
describe playlistcontent;
drop table playlistcontent;
select * from song;
select * from podcastepisode;
select * from playlist;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- VIEW 
create view viewplaylist as
select  playlistname,playlistduration,songname,duration,episodeName,episodeDuration from playlist join playlistcontent on playlist.playlistid=playlistcontent.playlistid 
left outer join song on playlistcontent.trackid=song.songid left outer join podcastepisode on playlistcontent.trackid=podcastepisode.podcastId;
select * from viewplaylist;
select * from podcastepisode;
select * from song;

