class TestCoreBD(nName:String,xs:Int,ys:Int,xe:Int,ye:Int):forCoreBD{
    override var name=nName
    override var xStart=xs
    override var yStart=ys
    override var xEnd=xe
    override var yEnd=ye
}
fun main(){
    testCoreBDNormal()
}

fun testCoreBDNormal():Int{
    var BD=coreBd(10+1,10+1)

    //test Add
    var test=TestCoreBD("",0,0,10,10)
    var error=BD.add(test)
    if (error!=0){
        print(error)
        return 10+error
    }
    for (i in BD.listBD){
        for (j in i){
            if (j!=0){
                print("add. not 0")
                return 1
            }
        }
    }
    print("add test parsed")
    //testDel
    error=BD.del(test)
    if (error!=0){
        print(error)
        return 10+error
    }
    for (i in BD.listBD){
        for (j in i){
            if (j!=-1){
                print("add. not 0")
                return 1
            }
        }
    }
    print("add test parsed")
    //testAddError

    //testDelError

    return 0
}