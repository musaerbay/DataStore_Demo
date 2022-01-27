# DataStore Demo

## DataStore Nedir ? 

Jetpack DataStore, key-value çiftlerini protocol buffers ile saklamanıza olanak tanıyan bir veri depolama çözümüdür.
DataStore, SharedPreferences yerine Kotlin Coroutine ve Flow yapıları ile asekron olarak lokal verilerimizi depolamaya yarayan Jetpack bileşenidir.
SharedPreferences'ın birçok dezavantajının üstesinden gelir.

## DataStore iki farklı uygulama sağlar :
* Preferences DataStore ; Anahtar(keys) kullanarak verileri depolar ve erişir. Tür güvenliği sağlamaz.
* Proto DataStore ; Verileri nesneler olarak depolar. Protocol buffers kullanarak bir şema tanımlamanızı gerektirir. Tür güvenliği sağlar.



![image](https://user-images.githubusercontent.com/81637840/151337736-af2d5184-e2dd-4bc1-8bc7-5d19ef8afb0c.png)
