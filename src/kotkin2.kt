

class Matrix(val a: Int ,val b: Int) {
    val table: MutableList<MutableList<Double>> = MutableList(a, { MutableList(b, {0.0}) })

    fun CreateMatrix() {
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                println("Введите число на место ($i, $j)")
                table[i-1][j-1] = readLine()!!.toDouble()
            }
        }
    }

    operator fun plus(other: Matrix): Matrix {
        val resul : Matrix = Matrix(a,b)
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                resul.table[i-1][j-1] = table[i-1][j-1] + other.table[i-1][j-1]
            }
        }
        return resul
    }

    operator fun plusAssign(other: Matrix) {
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                table[i-1][j-1] = table[i-1][j-1] + other.table[i-1][j-1]
            }
        }
    }

    operator fun minus(other: Matrix): Matrix {
        val resul : Matrix = Matrix(a,b)
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                resul.table[i-1][j-1] = table[i-1][j-1] - other.table[i-1][j-1]
            }
        }
        return resul
    }

    operator fun minusAssign(other: Matrix) {
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                table[i-1][j-1] = table[i-1][j-1] - other.table[i-1][j-1]
            }
        }
    }

    fun multiplication(other: Matrix): Matrix {
        val resul : Matrix = Matrix(table.size,other.table.size)
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                for(k in 1..table.size)
                {
                    resul.table[i - 1][j - 1] += table[i - 1][k - 1] * other.table[k - 1][j - 1]
                }
            }
        }
        return resul
    }

    fun multiplicationAssign(other: Matrix) {
        val resul : MutableList<MutableList<Double>> = MutableList(table.size, { MutableList(other.table.size, {0.0}) })
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                for(k in 1..table.size)
                    resul[i - 1][j - 1] += table[i - 1][k - 1] * other.table[k - 1][j - 1]
            }
        }
//        table = NULL
    }

//    operator fun times(scalar: Double) {
//
//    }
//
//    operator fun timesAssign(scalar: Double) {
//
//    }

    operator fun set(i: Int, j: Int, value: Double) {
        println(table[i][j])
    }

    operator fun get(i: Int, j: Int): Double {
        return table[i][j]
    }

    operator fun unaryMinus(): Matrix {
        val resul : Matrix = Matrix(a,b)
        for(i in 1..a)
        {
            for(j in 1..b)
            {
                resul.table[i-1][j-1] = table[i-1][j-1]
            }
        }
        return resul
    }

    operator fun unaryPlus(): Matrix {
        return this
    }
    // ...
}



fun main(args: Array<String>)
{
    val r : Matrix = Matrix(3,4)
    r.CreateMatrix()

}
