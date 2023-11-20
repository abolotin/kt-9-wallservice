import org.junit.Test

import org.junit.Assert.*
import ru.netology.Post
import ru.netology.WallService

class WallServiceTest {

    @Test
    fun addTest() {
        WallService.clear()
        val post = WallService.add(Post(id = 0, text = "Post 1"))

        assertNotEquals(0, post.id)
    }

    @Test
    fun updateExistingTest() {
        WallService.clear()
        val postOriginal = WallService.add(Post(id = 0, text = "Original post"))
        val postModified = Post(id = postOriginal.id, text = "Modified post")

        assertEquals(true, WallService.update(postModified))
    }

    @Test
    fun updateNonExistingTest() {
        WallService.clear()
        val postOriginal = WallService.add(Post(id = 0, text = "Original post"))
        val postModified = Post(id = 0, text = "Modified post")

        assertEquals(false, WallService.update(postModified))
    }
}