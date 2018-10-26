package jdregistry.client.data

import org.junit.jupiter.api.Test

class RepositoryNameTests {

//    private val repos = listOf(
//            RepositoryName("namespace/repo1"),
//            RepositoryName("repo2")
//    )
//    private val tags = listOf(
//            Tag.LATEST,
//            Tag.from("other")
//    )
//
//    @Test
//    fun resolve_tag() {
//
//        val expected = listOf(
//                "namespace/repo1:latest",
//                "namespace/repo1:other",
//                "repo2:latest",
//                "repo2:other"
//        )
//        cross(repos, tags).forEachIndexed { index, pair ->
//
//            Assert.assertEquals(pair.first.resolve(pair.second), expected[index])
//        }
//
//        // resolve implicit
//        Assert.assertEquals(repo0.resolve(), "namespace/repo1:latest")
//        Assert.assertEquals(repo1.resolve(), "repo2:latest")
//    }
//
//    @Test
//    fun some_valid_repos() {
//
//        RepositoryName("foo/bar")
//        RepositoryName("foo")
//    }
//
//    @Test(expected = IllegalArgumentException::class)
//    fun invalid_first_path_1() {
//
//        RepositoryName(invalidIdentifier)
//    }
//
//    @Test(expected = IllegalArgumentException::class)
//    fun invalid_first_path_2() {
//
//        RepositoryName(EMPTY)
//    }
//
//    @Test(expected = IllegalArgumentException::class)
//    fun invalid_second_path_1() {
//
//        RepositoryName("jboss", listOf(EMPTY))
//    }
//
//    @Test(expected = IllegalArgumentException::class)
//    fun invalid_second_path_2() {
//
//        RepositoryName("jboss", listOf(invalidIdentifier))
//    }
//
//    @Test(expected = IllegalArgumentException::class)
//    fun too_long_repository_name() {
//
//        RepositoryName("a".repeat(400))
//    }
//
//    @Test
//    fun get() {
//
//        Assert.assertEquals(repo0[0], repo0.firstPathComponent)
//        Assert.assertEquals(repo1[0], repo1.firstPathComponent)
//        Assert.assertEquals(repo0[0], "namespace")
//        Assert.assertEquals(repo1[0], "repo2")
//        Assert.assertEquals(repo0[1], "repo1")
//    }
//
//    @Test
//    fun to_string() {
//
//        Assert.assertEquals(repo0.toString(), "namespace/repo1")
//        Assert.assertEquals(repo1.toString(), "repo2")
//    }
//
//    @Test
//    fun as_string() {
//
//        Assert.assertEquals(repo0.asString(), "namespace/repo1")
//        Assert.assertEquals(repo1.asString(), "repo2")
//    }
//
//    @Test
//    fun to_string_and_as_string_are_the_same() {
//
//        Assert.assertEquals(repo0.asString(), repo0.toString())
//        Assert.assertEquals(repo1.asString(), repo1.toString())
//    }
//
//    @Test
//    fun resolve_with_hostname() {
//
//        // Explicit Tag
//        Assert.assertEquals(repo0.resolve(tag0, "docker.io"), "docker.io/namespace/repo1:latest")
//        Assert.assertEquals(repo0.resolve(tag1, "docker.io"), "docker.io/namespace/repo1:other")
//        Assert.assertEquals(repo0.resolve(tag0, "localhost:3000"), "localhost:3000/namespace/repo1:latest")
//        Assert.assertEquals(repo0.resolve(tag1, "localhost:3000"), "localhost:3000/namespace/repo1:other")
//
//        Assert.assertEquals(repo1.resolve(tag0, "docker.io"), "docker.io/repo2:latest")
//        Assert.assertEquals(repo1.resolve(tag1, "docker.io"), "docker.io/repo2:other")
//        Assert.assertEquals(repo1.resolve(tag0, "localhost:3000"), "localhost:3000/repo2:latest")
//        Assert.assertEquals(repo1.resolve(tag1, "localhost:3000"), "localhost:3000/repo2:other")
//
//        // Implicit Tag
//        Assert.assertEquals(repo0.resolve(host = "docker.io"), "docker.io/namespace/repo1:latest")
//        Assert.assertEquals(repo0.resolve(host = "localhost:3000"), "localhost:3000/namespace/repo1:latest")
//
//        Assert.assertEquals(repo1.resolve(host = "docker.io"), "docker.io/repo2:latest")
//        Assert.assertEquals(repo1.resolve(host = "localhost:3000"), "localhost:3000/repo2:latest")
//    }
//
//    @Test
//    fun resolve_with_hostname_slash() {
//
//        // Explicit tag
//        Assert.assertEquals(repo0.resolve(tag0, "docker.io/"), "docker.io/namespace/repo1:latest")
//        Assert.assertEquals(repo0.resolve(tag1, "docker.io/"), "docker.io/namespace/repo1:other")
//        Assert.assertEquals(repo0.resolve(tag0, "localhost:3000/"), "localhost:3000/namespace/repo1:latest")
//        Assert.assertEquals(repo0.resolve(tag1, "localhost:3000/"), "localhost:3000/namespace/repo1:other")
//
//        Assert.assertEquals(repo1.resolve(tag0, "docker.io/"), "docker.io/repo2:latest")
//        Assert.assertEquals(repo1.resolve(tag1, "docker.io/"), "docker.io/repo2:other")
//        Assert.assertEquals(repo1.resolve(tag0, "localhost:3000/"), "localhost:3000/repo2:latest")
//        Assert.assertEquals(repo1.resolve(tag1, "localhost:3000/"), "localhost:3000/repo2:other")
//
//        // Implicit Tag
//        Assert.assertEquals(repo0.resolve(host = "docker.io/"), "docker.io/namespace/repo1:latest")
//        Assert.assertEquals(repo0.resolve(host = "localhost:3000/"), "localhost:3000/namespace/repo1:latest")
//
//        Assert.assertEquals(repo1.resolve(host = "docker.io/"), "docker.io/repo2:latest")
//        Assert.assertEquals(repo1.resolve(host = "localhost:3000/"), "localhost:3000/repo2:latest")
//    }
}
