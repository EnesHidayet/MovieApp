# User entity için bütün katmanları ekleyelim.
# Crud metotlarının ortak üretildiği bir yapı kuralım.(ICRUDService)
# UserService de bir register metodu yazalım.(register --> name,surname,email,rePassword)
# Bir login metodu yazalım. Repository'de email ve şifreye göre kullanıcı dönen bir metot yazılması gereklidir.
# veri tabanında bu kullanıcı var ise sisteme giriş yapabilmeyilim.

# Login metodunu Dto ile tekrar yazalım -> loginDto()