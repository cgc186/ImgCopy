import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.*


fun main() {
//    changeName()
    changeLocation()
}

fun changeLocation() {
    val file = File("E:\\备份\\OneDrive - Dezhkeda\\ip\\20200511\\pcr")
//    val list = listFiles(file)
    val fileList: MutableList<File> = ArrayList()
    if (file.isDirectory) {
        for (listFile in file.listFiles()) {
            val filename = listFile.absolutePath + "\\1"
//            println(filename)
            val file1 = File(filename)
            if (file1.exists() && file1.isDirectory) {
                for (pic in file1.listFiles()) {
//                    println(pic.name)
                    val newName = listFile.absolutePath + "\\" + pic.name
                    pic.renameTo(File(newName))
                }
            }
        }
    }


}

fun changeName() {
    val file = File("E:\\备份\\OneDrive - Dezhkeda\\ip\\未命名文件夹")
    val list = listFiles(file)
    for (o in list) {
//        println(o.name)
//        println(o.absolutePath)
        val newName = o.name.substring(2)
        println(newName)
        o.renameTo(File(newName))
    }
}

fun copy() {
    val file = File("G:/painting")
    val out = "G:/out/"
    val op = ".png"
    val list = listFiles(file)
    for (o in list) {
        println(o.name)
        if (o.name.contains(op, true)) {
            println(o.absolutePath)
            println(out + o.name)
            Files.copy(Paths.get(o.absolutePath), Paths.get(out + o.name), StandardCopyOption.REPLACE_EXISTING)
        }
    }
}


fun listFiles(file: File): Collection<File> {
    val fileList: MutableList<File> = ArrayList()
    if (file.isDirectory) {
        for (listFile in file.listFiles()) {
            fileList.addAll(listFiles(listFile))
        }
    } else {
        fileList.add(file)
    }
    return fileList
}
