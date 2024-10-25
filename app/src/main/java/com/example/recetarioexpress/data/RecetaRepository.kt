package com.example.recetarioexpress.data

import com.example.recetarioexpress.model.Receta

object RecetaRepository {

    fun obtenerRecetas(): List<Receta> {
        return listOf(
            Receta(
                id = "1",
                nombre = "Tarta de Manzana",
                descripcion = "Una deliciosa tarta de manzana casera.",
                ingredientes = listOf("Manzanas", "Azúcar", "Harina", "Huevos"),
                materiales = listOf("Horno", "Molde para tarta"),
                instrucciones = "1. Precalentar el horno. 2. Pelar y cortar las manzanas...",
                imagenUrl = "https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/A73F095D-A41C-4C81-A87D-00F5E4D3D638/Derivates/33FEF576-49A1-47C4-BBB9-BA9ED1B7C5BE.jpg"
            ),
            Receta(
                id = "2",
                nombre = "Brownies de Chocolate",
                descripcion = "Brownies húmedos y esponjosos.",
                ingredientes = listOf("Chocolate", "Mantequilla", "Azúcar", "Harina"),
                materiales = listOf("Molde para hornear", "Batidora"),
                instrucciones = "1. Derretir el chocolate y la mantequilla...",
                imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRquXsimMz1PfvJ0wGK-Bb9gCcA9MXZi306pQ&s"
            ),
            Receta(
                id = "3",
                nombre = "Pizza Margarita",
                descripcion = "Una pizza simple con salsa de tomate y albahaca.",
                ingredientes = listOf("Harina", "Tomates", "Queso Mozzarella", "Albahaca"),
                materiales = listOf("Horno", "Piedra para pizza"),
                instrucciones = "1. Preparar la masa. 2. Extender la salsa y el queso...",
                imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZjo9nnM4x4yqYkNG8kQmUvHpcpPr1pvlOGA&s"
            ),
            Receta(
                id = "4",
                nombre = "Pasta Carbonara",
                descripcion = "Una pasta cremosa con panceta y huevo.",
                ingredientes = listOf("Pasta", "Huevos", "Panceta", "Parmesano"),
                materiales = listOf("Olla", "Sartén"),
                instrucciones = "1. Cocer la pasta. 2. Cocinar la panceta...",
                imagenUrl = "https://upload.wikimedia.org/wikipedia/commons/3/30/Spaghetti_carbonara.jpg"
            ),
            Receta(
                id = "5",
                nombre = "Ensalada César",
                descripcion = "Clásica ensalada con pollo y aderezo César.",
                ingredientes = listOf("Lechuga", "Pollo", "Croutones", "Queso parmesano"),
                materiales = listOf("Tazón", "Cuchillo"),
                instrucciones = "1. Mezclar los ingredientes. 2. Agregar el aderezo...",
                imagenUrl = "https://www.gourmet.cl/wp-content/uploads/2016/09/Ensalada_C%C3%A9sar-web-553x458.jpg"
            ),
            Receta(
                id = "6",
                nombre = "Sopa de Tomate",
                descripcion = "Una sopa reconfortante de tomate.",
                ingredientes = listOf("Tomates", "Cebolla", "Ajo", "Caldo de vegetales"),
                materiales = listOf("Olla", "Licuadora"),
                instrucciones = "1. Saltear la cebolla y el ajo. 2. Añadir los tomates...",
                imagenUrl = "https://images.cookforyourlife.org/wp-content/uploads/2015/08/tomato-soup-with-basil-and-pesto.jpg"
            ),
            Receta(
                id = "7",
                nombre = "Lasaña de Carne",
                descripcion = "Una lasaña con carne molida y queso.",
                ingredientes = listOf("Pasta de lasaña", "Carne molida", "Salsa de tomate", "Queso ricotta"),
                materiales = listOf("Horno", "Fuente para hornear"),
                instrucciones = "1. Cocinar la carne. 2. Montar las capas de lasaña...",
                imagenUrl = "https://content-cocina.lecturas.com/medio/2023/07/29/lasana-de-carne-sin-horno_00000000_231020125919_600x600.jpg"
            ),
            Receta(
                id = "8",
                nombre = "Arroz con Pollo",
                descripcion = "Un plato clásico de arroz con pollo y vegetales.",
                ingredientes = listOf("Arroz", "Pollo", "Pimientos", "Cebolla"),
                materiales = listOf("Olla", "Cuchillo"),
                instrucciones = "1. Cocer el pollo. 2. Sofreír los vegetales...",
                imagenUrl = "https://antojandoando.com/wp-content/uploads/2015/01/arroz-pollo2-pint-pq.jpg"
            ),
            Receta(
                id = "9",
                nombre = "Hamburguesa Clásica",
                descripcion = "Jugosa hamburguesa de carne con queso.",
                ingredientes = listOf("Carne molida", "Queso", "Pan de hamburguesa", "Lechuga"),
                materiales = listOf("Parrilla", "Espátula"),
                instrucciones = "1. Formar las hamburguesas. 2. Cocinar a la parrilla...",
                imagenUrl = "https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/FBB73F91-2A4F-475E-BB25-CE12D72C9D19/Derivates/d1eddcbc-5604-4592-bb85-1ef70ee15f96.jpg"
            ),
            Receta(
                id = "10",
                nombre = "Pollo al Horno",
                descripcion = "Pollo dorado y jugoso cocido al horno.",
                ingredientes = listOf("Pollo", "Aceite de oliva", "Hierbas", "Limón"),
                materiales = listOf("Horno", "Fuente para hornear"),
                instrucciones = "1. Marinar el pollo. 2. Hornear hasta que esté dorado...",
                imagenUrl = "https://www.recetasnestle.cl/sites/default/files/srh_recipes/4d95ee421422145ef856c040751d4386.jpg"
            ),
            Receta(
                id = "11",
                nombre = "Tacos de Carne",
                descripcion = "Tacos con carne sazonada y guacamole.",
                ingredientes = listOf("Tortillas", "Carne de res", "Guacamole", "Queso"),
                materiales = listOf("Sartén", "Cuchillo"),
                instrucciones = "1. Cocinar la carne. 2. Montar los tacos...",
                imagenUrl = "https://www.gourmet.cl/wp-content/uploads/2021/08/Tacos_Carne_Interior_Gourmet.jpg"
            ),
            Receta(
                id = "12",
                nombre = "Panqueques Americanos",
                descripcion = "Panqueques esponjosos perfectos para el desayuno.",
                ingredientes = listOf("Harina", "Huevos", "Leche", "Mantequilla"),
                materiales = listOf("Sartén", "Batidora"),
                instrucciones = "1. Mezclar los ingredientes. 2. Cocinar en una sartén...",
                imagenUrl = "https://osojimix.com/wp-content/uploads/2021/07/PANCAKES-AMERICANOS-500x375.jpg"
            ),
            Receta(
                id = "13",
                nombre = "Galletas con Chispas de Chocolate",
                descripcion = "Galletas suaves con chispas de chocolate.",
                ingredientes = listOf("Harina", "Mantequilla", "Azúcar", "Chispas de chocolate"),
                materiales = listOf("Batidora", "Bandeja para hornear"),
                instrucciones = "1. Mezclar los ingredientes. 2. Formar las galletas...",
                imagenUrl = "https://cdn0.recetasgratis.net/es/posts/6/4/1/galletas_con_chispas_de_chocolate_y_nueces_32146_600_square.jpg"
            ),
            Receta(
                id = "14",
                nombre = "Ceviche de Pescado",
                descripcion = "Un fresco ceviche de pescado con limón.",
                ingredientes = listOf("Pescado", "Limón", "Cebolla", "Cilantro"),
                materiales = listOf("Tazón", "Cuchillo"),
                instrucciones = "1. Marinar el pescado en limón. 2. Añadir los vegetales...",
                imagenUrl = "https://d36fw6y2wq3bat.cloudfront.net/recipes/ceviche-de-pescado/900/ceviche-de-pescado_version_1670231839.jpg"
            ),
            Receta(
                id = "15",
                nombre = "Sushi Roll",
                descripcion = "Sushi con arroz, pescado y vegetales.",
                ingredientes = listOf("Arroz para sushi", "Pescado", "Alga nori", "Aguacate"),
                materiales = listOf("Esterilla para sushi", "Cuchillo"),
                instrucciones = "1. Preparar el arroz. 2. Enrollar con el pescado...",
                imagenUrl = "https://www.gourmet.cl/wp-content/uploads/2016/09/Crispy-Rolls-iStock-817071822-Nuevo-570x458.jpg"
            ),
            Receta(
                id = "16",
                nombre = "Quiche de Espinacas",
                descripcion = "Quiche horneado con espinacas y queso.",
                ingredientes = listOf("Huevos", "Espinacas", "Queso", "Harina"),
                materiales = listOf("Molde para quiche", "Horno"),
                instrucciones = "1. Preparar la masa. 2. Añadir las espinacas y hornear...",
                imagenUrl = "https://comedera.com/wp-content/uploads/sites/9/2018/09/quiche-de-espinacas.jpg"
            ),
            Receta(
                id = "17",
                nombre = "Paella",
                descripcion = "Tradicional paella de mariscos.",
                ingredientes = listOf("Arroz", "Camarones", "Mejillones", "Azafrán"),
                materiales = listOf("Sartén grande", "Cuchillo"),
                instrucciones = "1. Cocinar los mariscos. 2. Añadir el arroz y el azafrán...",
                imagenUrl = "https://www.nestleprofessional-latam.com/sites/default/files/styles/np_recipe_detail/public/2022-07/paella.png?itok=CBvKkcsa"
            ),
            Receta(
                id = "18",
                nombre = "Croquetas de Jamón",
                descripcion = "Crujientes croquetas de jamón con bechamel.",
                ingredientes = listOf("Jamón", "Harina", "Leche", "Pan rallado"),
                materiales = listOf("Sartén", "Cuchara"),
                instrucciones = "1. Preparar la bechamel con jamón. 2. Freír las croquetas...",
                imagenUrl = "https://i.blogs.es/70b1b8/croquetas_jamon/450_1000.jpg"
            ),
            Receta(
                id = "19",
                nombre = "Salmón a la Plancha",
                descripcion = "Salmón cocido a la plancha con hierbas.",
                ingredientes = listOf("Salmón", "Aceite de oliva", "Limón", "Romero"),
                materiales = listOf("Sartén", "Espátula"),
                instrucciones = "1. Sazonar el salmón. 2. Cocinar a la plancha...",
                imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZHqHq_T4qmbc_eU1XXWCDfSAsaZEkjf_L4w&s"
            ),
            Receta(
                id = "20",
                nombre = "Flan de Vainilla",
                descripcion = "Suave flan con sabor a vainilla.",
                ingredientes = listOf("Huevos", "Leche", "Azúcar", "Vainilla"),
                materiales = listOf("Molde para flan", "Horno"),
                instrucciones = "1. Mezclar los ingredientes. 2. Hornear en baño María...",
                imagenUrl = "https://images.aws.nestle.recipes/original/f07639d0bdf09dac4f27aa9562bf15a9_FLAN_DE_VAINILLA.jpg"
            ),
            Receta(
                id = "21",
                nombre = "Crepes de Nutella",
                descripcion = "Deliciosos crepes rellenos de Nutella.",
                ingredientes = listOf("Harina", "Huevos", "Leche", "Nutella"),
                materiales = listOf("Sartén", "Batidora"),
                instrucciones = "1. Preparar la mezcla de crepes. 2. Cocinar y rellenar con Nutella...",
                imagenUrl = "https://www.recetasfusion.com/wp-content/uploads/2020/01/crepes-integrales-con-nutella-y-fresas-version-saludable-RecetasFusion.jpg"
            ),
            Receta(
                id = "22",
                nombre = "Tiramisú",
                descripcion = "Postre italiano con café y mascarpone.",
                ingredientes = listOf("Bizcochos de soletilla", "Café", "Mascarpone", "Cacao en polvo"),
                materiales = listOf("Tazón", "Batidora"),
                instrucciones = "1. Mojar los bizcochos en café. 2. Montar con mascarpone...",
                imagenUrl = "https://recetasdecocina.elmundo.es/wp-content/uploads/2022/08/tiramisu-postre-italiano.jpg"
            )
        )
    }

    fun obtenerRecetaPorId(id: String): Receta? {
        val recetas = obtenerRecetas()
        return recetas.find { it.id == id }
    }
}

