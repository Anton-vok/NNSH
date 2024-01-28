interface forCoreBD{
    var name:String
    var xStart:Int
    var xEnd:Int
    var yStart:Int
    var yEnd:Int
}

class coreBd(
    var MAX_X:Int,
    var MAX_Y:Int
){
    // Имена для значений X и Y
    var xNameList=Array(MAX_X) {it}
    var yNameList=Array(MAX_Y) {it}

    // Доступные для использования значения
    var toUse= mutableListOf<Int>()
    // Список элементов
    var listElements= mutableListOf<forCoreBD>()
    // Карта элементов
    var listBD=Array(MAX_X) { List(MAX_Y) {-1} }

    fun add( addElement:forCoreBD ):Int{

        // Проверка индексов X и Y и выдача ошибок при их не соответствии
        if ((addElement.xStart>addElement.xEnd)||(addElement.yStart>addElement.yEnd)){
            return -3
        }
        if ((addElement.xStart<0)||(addElement.yStart<0)){
            return -2
        }
        if (addElement.xEnd>MAX_X-1 || addElement.yEnd>MAX_Y-1){
            return -1
        }

        // Заполнение списка элементов новым уроком
        var newListElements=listElements
        var newToUse=toUse
        var index=0
        if(toUse.isEmpty()){
            index=newListElements.size
            newListElements.add(addElement)
        } else{
            index=newToUse[0]
            newToUse.removeAt(0)
            newListElements[index]=addElement
        }

        //Добавление элементов в 2D массив
        var newList=listBD
        for (i in addElement.xStart..addElement.xEnd){
            var dopList=newList[i].toMutableList()
            for (j in addElement.yStart..addElement.yEnd){
                if (newList[i][j]!=-1){
                    return 1
                } else {
                    dopList[j]=index
                }
            }
            newList[i]=dopList.toList()
        }

        //Применение изменений
        listBD=newList
        listElements=newListElements
        toUse=newToUse

        // Возрат стандартного значения
        return 0
    }

    fun del( element:forCoreBD ):Int {

        //Нахождение index объекта и вобще его присутствие
        var index = listElements.indexOf(element)
        if (index==-1){
            return -1
        }

        //обновление 2D массива
        var have=true
        toUse.add(index)
        for (i in 0 until listBD.size){
            var dopList=listBD[i].toMutableList()
            for (j in 0 until listBD[0].size){
                if (listBD[i][j]==index){
                    have=false
                    dopList[j]=-1
                }
            }
            listBD[i]=dopList.toList()
        }

        //Возвращяем ошибку если значение не разу не было встречено
        if(have){
            return -2
        }

        // Возвращяем стандартный код
        return 0
    }

}