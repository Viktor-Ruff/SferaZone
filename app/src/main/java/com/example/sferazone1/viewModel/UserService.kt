package com.example.sferazone1.viewModel

import com.example.sferazone1.model.ImageModel
import com.example.sferazone1.model.PeopleModel
import com.github.javafaker.Faker

/**
 * Created by Viktor-Ruff
 * Date: 01.11.2022
 * Time: 18:12
 */
class UserService {

    fun initPeopleList(count: Int): List<PeopleModel> {


        images.shuffle()
        val peopleList: List<PeopleModel>
        val faker: Faker = Faker.instance()
        peopleList = (1..count).map {

            val randomSubscription = Math.random() * 10
            val randomSubscriber = Math.random() * 10

            PeopleModel(
                id = it,
                name = faker.name().name(),
                profileImage = images[it % images.size],
                subscription = randomSubscription >= 5,
                subscriber = true
            )
        }
        return peopleList
    }


    fun subscriptionList(list: List<PeopleModel>): List<PeopleModel> {

        var subscriptionList = ArrayList<PeopleModel>()

        for (people in list) {
            if (people.subscription) {
                subscriptionList.add(people)
            }
        }

        return subscriptionList.toList()
    }


    fun mutuallyList(list: List<PeopleModel>): List<PeopleModel> {

        var mutuallyList = ArrayList<PeopleModel>()

        for (people in list) {
            if (people.subscriber && people.subscription) {
                mutuallyList.add(people)
                println("${people.name}: ${people.subscriber} и ${people.subscription}")
            }
        }

        return mutuallyList.toList()
    }


    fun initImagesUserLIst(): List<ImageModel> {
        return listOf(
            ImageModel("https://images.unsplash.com/photo-1636705451731-ebd358d45605?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"),
            ImageModel("https://images.unsplash.com/photo-1636704593233-0b40bfa91010?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDJ8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"),
            ImageModel("https://images.unsplash.com/photo-1636572729926-9b27f634e787?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"),
            ImageModel("https://images.unsplash.com/photo-1636572712279-72d88e81c3bd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80")
        )
    }


    fun initMomentsList(): List<ImageModel> {
        return listOf(
            ImageModel("https://i.pinimg.com/736x/26/b2/26/26b226453ab2cd4607df270aa21791f3--kendall-jenner-nails-kendall-jenner-outfits.jpg"),
            ImageModel("https://i.pinimg.com/736x/0e/45/24/0e4524d23b5d22d1dd1df5305ee8cd61.jpg"),
            ImageModel("https://i.pinimg.com/736x/6c/fa/db/6cfadb67a66539cd1ad3bf9e2f04bf24.jpg"),
            ImageModel("https://jo-jo.ru/uploads/posts/2014-03/thumbs/1395912868_007.jpg"),
            ImageModel("https://i.pinimg.com/736x/d3/43/53/d34353f1a6c4e6f6b7c95c52e604e176.jpg"),
            ImageModel("https://i.pinimg.com/736x/1f/4e/67/1f4e674b5b9ca08de109ae779104cee1.jpg"),
        )
    }


    fun initChroniclesList(): List<ImageModel> {
        return listOf(
            ImageModel("https://avatars.mds.yandex.net/i?id=cd55adb5e2757ac2c7a91fc8032bd0c3-6960402-images-thumbs&n=13&exp=1"),
            ImageModel("https://avatars.mds.yandex.net/i?id=2beb9c3d7ddf845672bd5577e6e13aa7512e3f00-5094251-images-thumbs&n=13&exp=1"),
            ImageModel("https://i.pinimg.com/736x/28/80/69/288069223bb0d7b4aaa2c2f594efdb04.jpg"),
            ImageModel("https://rnnetwork.com/blog/wp-content/uploads/2015/09/20150917_great_to_be_travel_nurse.jpg"),
            ImageModel("https://i.pinimg.com/736x/a5/6d/ea/a56dea50c8ddaa948b9744139b2f7c1d.jpg"),
            ImageModel("https://avatars.mds.yandex.net/i?id=ad7c795c6ca76a8dd7a5d4eff44e8dec-5359329-images-thumbs&n=13&exp=1"),
            ImageModel("https://i.pinimg.com/736x/1a/73/c0/1a73c0f4778da224c1f5dc10c3789418--yosemite-national-park-national-parks.jpg"),
            ImageModel("https://i.pinimg.com/736x/5d/0f/dd/5d0fdde276309fd89fc05874ec37309f.jpg"),
            ImageModel("https://i.pinimg.com/originals/1f/a6/90/1fa69086cdde29259bf65b1bf5b99d27.jpg"),
            ImageModel("https://i.pinimg.com/736x/0d/1b/6c/0d1b6cea3e833175e5525286861c28a0.jpg"),
            ImageModel("https://i.pinimg.com/736x/20/ac/fb/20acfb29dd51891a8ab767861aa765dd.jpg"),
            ImageModel("https://data.whicdn.com/images/270476674/original.jpg")
        )
    }


    private val images: MutableList<String> = mutableListOf(
        "https://yandex-images.clstorage.net/N9Uwo8357/dcf929m_9W/ifpP_DCmnG052w5m-q6WdBSwuLyBDs_PeJhzYDsXosEGsNnzlwxPn0iYIPF5F----GuWuNWEYrIokrUpZ4XoAsqoA7AruNNnONsNa_O1n3MfuLe0hRrIzSDPaDhnBauUGKHXpv1nP-ZuoQrBCGSWyLY-yeWEzS7mcsncW3Lbp2Kx8UnoI7PDaxT4VEfvqatUP8uaq4NM4r5mtSkjSyP6nSe5gNbodjz_dZEKxzF5sP-4GOX2seVG6FH0yXIH1bhTre1izi-n41oc7HVs3ZecWgnMsJehb8iifY4rHGAv-ZgTpKDg1GIu4lWYL_8OVb3hgTfz-Zfmatdwysd3K_2VcrbTT_wopMdmLOFXbe-rlnYb166SnmjLvUS2GiN4HcKhCZWE3dFeNdB2rgnRAmGp46Q51MyE5Gf_aujvTgrBk1iPy2vqEq3jdzDfS03JmpZ5BPODqqRF06hBrQ0ybRzjuyeWhtDGYgfyXY0I4TVQiO6sCPHRi9xEylLsxEY04apUscNa8iWT1Fkqw1lmy5WbXAnSvbKvZOq5d4w-IXg5_qAXhb_O6G0s4EeIF-ACR7vRrR3L9az7bfds5_phA_mibp7rbs80gdpUPO11XvWop0Yax7ixt2f_lUC_JTBMFuK3Jb2M09BJHchujTbkIHmSwb0T6cyr0GLsUsbvcTj6gG232UH0AabeaTjtRG_-p7h_JeSMsK113ptnqS8-RgPGnRWZjO_DSwfMXJoc5yZ0m8O7GtTrt_h0ylTi6WMr2IJWtNhDzjCww0cn8WJY_4OhWSD8jomdVMOcY5AqGmwN2bQUn6L0-F4P1lyQB90RRIbMhinG5YLCY8hnweppM9m6eazBffYLvNtiLslRVcuPolw_6LO0kVP-qEC2Nz1cHcG9FL-g-OZvC-tilSrEGGatxIMP3dm5wGX1Xs3VVRvukXiwzVPcJLP8QRnZZHTsprhcP82Pj7l3_KNjuTg3UB4",
        "https://avatars.mds.yandex.net/i?id=1af382048d30d57bc65d2a68551636c0-4470903-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=0c865367bdcc2ca206ff9bb49fe0a3078b1a7707-5221296-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=315f990915548786ed9fa2499a24dcd1e6b7fec4-4555484-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=db97ecef5b8152918ebec2a29d8aaefa11185d13-6946760-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=89f1f3b187ed9164a375014d67dabd11-4268599-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=ff17bf16d602afa63ccae7929605652f-5246707-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=6e60ca94a4fbc8e84d052cbfcd7d1536abf4bc6e-5210052-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=952ac698dc6c9dc36e4c618ee8bf1e98-5906726-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=e3fe838baf6d03b94cb026e8494734c2-5241810-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=ac7d2162068e4977ff62105f9aee3c47-4863774-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=236b1c110a8a80443e774a970abe6272-4322260-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=a15d4fda59c781537901548f4098bf2a-5026382-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=36ae69d87571b41fa1e0a0321f1244cb-5865525-images-thumbs&n=13&exp=1",
        "https://herbusiness.com/wp-content/uploads/2015/11/Use-content-to-turn-strangers-into-promoters.jpg",
        "https://dspncdn.com/a1/avatars/400x/b0/9f/b09f8ad1573ccb34649ac1318e1797d1.jpg",
        "https://avatars.mds.yandex.net/i?id=523d41a50f4bb0baa634fdfefa3773b2-5476568-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=b0a31395660ccca40dc06aea335079ec-5233858-images-thumbs&n=13&exp=1",
        "https://avatars.mds.yandex.net/i?id=93efa65056bcfe880d1386bde922d4c49c478e65-4761754-images-thumbs&n=13&exp=1",
        "https://yandex-images.clstorage.net/N9Uwo8357/dcf929m_9W/ifpP_DCmnG052w5m-q6WdBSwuLyBDs_PeJhzb29GoZQC4tuvlQhIkUjMcKEiG7rj_Wyf49SBNbIlxucpZ4bjBcyuC7AruNNnONsNa_O1n3MfuLe0hRrIzSDPaDhnBauUGKHXpv1nP-ZuoQrBCGSWyLY-yeWEzS7mcsncW3Lbp2Kx8UnoI7PDaxT4VEfvqatUP8uaq4NM4r5mtSkjSyP6nSe5gNbodjz_dZEKxzF5sP-4GOX2seVG6FH0yXIH1bhTre1izi-n41oc7HVs3ZecWgnMsJehb8iifY4rHGAv-ZgTpKDg1GIu4lWYL_8OVb3hgTfz-Zfmatdwysd3K_2VcrbTT_wopMdmLOFXbe-rlnYb166SnmjLvUS2GiN4HcKhCZWE3dFeNdB2rgnRAmGp46Q51MyE5Gf_aujvTgrBk1iPy2vqEq3jdzDfS03JmpZ5BPODqqRF06hBrQ0ybRzjuyeWhtDGYgfyXY0I4TVQiO6sCPHRi9xEylLsxEY04apUscNa8iWT1Fkqw1lmy5WbXAnSvbKvZOq5d4w-IXg5_qAXhb_O6G0s4EeIF-ACR7vRrR3L9az7bfds5_phA_mibp7rbs80gdpUPO11XvWop0Yax7ixt2f_lUC_JTBMFuK3Jb2M09BJHchujTbkIHmSwb0T6cyr0GLsUsbvcTj6gG232UH0AabeaTjtRG_-p7h_JeSMsK113ptnqS8-RgPGnRWZjO_DSwfMXJoc5yZ0m8O7GtTrt_h0ylTi6WMr2IJWtNhDzjCww0cn8WJY_4OhWSD8jomdVMOcY5AqGmwN2bQUn6L0-F4P1lyQB90RRIbMhinG5YLCY8hnweppM9m6eazBffYLvNtiLslRVcuPolw_6LO0kVP-qEC2Nz1cHcG9FL-g-OZvC-tilSrEGGatxIMP3dm5wGX1Xs3VVRvukXiwzVPcJLP8QRnZZHTsprhcP82Pj7l3_KNjuTg3UB4"
    )

}