-- 1. Finding 5 oldest users

SELECT * FROM users
ORDER BY created_at
LIMIT 5;

SELECT DAYNAME(created_at) AS day, COUNT(*) AS total FROM users
GROUP BY day
ORDER BY total DESC
LIMIT 2;

-- 3. Identify Inactive Users (Users with no photos)

SELECT username FROM users
LEFT JOIN photos ON photos.user_id = users.id
WHERE image_url IS NULL;

SELECT username FROM users;

-- Identify most popular photo(and who user created it)
SELECT username, photos.id, image_url, COUNT(*) AS total from users
JOIN photos ON photos.user_id = users.id
JOIN likes ON likes.photo_id = photos.id
GROUP BY photos.id
ORDER BY total DESC
LIMIT 1;

-- calucate avg number of photos per person
-- total number of photos / total number of users 
SELECT (SELECT COUNT(*) FROM photos) / (SELECT COUNT(*) FROM users) AS avg;

SELECT tag_name, COUNT(*) AS total FROM tags
JOIN photo_tags ON photo_tags.tag_id = tags.id
GROUP BY tags.id
ORDER BY total DESC
LIMIT 5;

SELECT username, Count(*) AS num_likes FROM users
JOIN likes ON likes.user_id = users.id
GROUP BY users.id
HAVING num_likes = (SELECT COUNT(*) FROM photos);


