package com.example.pinterestclone.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pinterestclone.R
import com.example.pinterestclone.adapter.SearchRecAdapter
import com.example.pinterestclone.model.SearchRecModelim

class UpdatesFragment : Fragment(R.layout.fragment_updates) {
    lateinit var list: ArrayList<SearchRecModelim>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        list = loadList()
        var rvUpdates = view?.findViewById<RecyclerView>(R.id.rv_updates1)
        val adapter = SearchRecAdapter(list)
        val layoutManager =
            GridLayoutManager(requireContext(), 2)
        rvUpdates?.adapter = adapter
        rvUpdates?.layoutManager = layoutManager
    }

    override fun onResume() {
        super.onResume()
        initViews()
    }

    private fun loadList(): ArrayList<SearchRecModelim> {
        var mylist = ArrayList<SearchRecModelim>()
        mylist.add(SearchRecModelim("data:image/jpeg;base64,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", "cavalet"))
        mylist.add(
            SearchRecModelim(
                "data:image/jpeg;base64,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",
                "Tesla"
            )
        )
        mylist.add(SearchRecModelim("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMSERUQEBIVFRIVFQ8QFxIXEBYYFxASFRUWFhUVFRcYHSggGBolHRUTITEhJSkrLi4uFx8zODMsNygtLisBCgoKDg0NFQ8QFS0dFx0tLSstLTcrLSsyKy0rKzAtLTctKy03LSsrLys1KzcrLy0rLzcrLTcrKzctNys3MCs3K//AABEIAKcBLQMBIgACEQEDEQH/xAAcAAEAAQUBAQAAAAAAAAAAAAAABAECBQYHAwj/xABFEAACAQICBQgFCQYGAwEAAAAAAQIDEQQhBRIxQVEGEyJhcYGR0QcyUqGxFEJTcoKSwdLhFSMzQ2KTFlSDovDxRLLCF//EABcBAQEBAQAAAAAAAAAAAAAAAAABAgP/xAAeEQEBAQABBAMAAAAAAAAAAAAAEQExAnGR8BIyQf/aAAwDAQACEQMRAD8A7iAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACkpJK7dlxZAr6dwsMp4minwdaF/C4GQBh3ypwX+ZpfeC5U4P8AzNP7wGYBh5cqMGv/ACaXdO/wPCfLPArbiF3QqP4RAz4Naly7wK/nN/6NX8pSPL3A/SyX+jU/CIGzAwdHlfgZbMTBfW1of+yRk8LpGjV/hVac/q1Iy+DAkgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMDyl5V0ME4wqXnUktZU42uo3trSu8ldNddnwZqeO9MGGo/wAajJZNqMakZTbtktWytftA6UYblByqweBjrYvEU6btdQbvOX1YRvJ+BwPlX6Zsdibww1sLSd10Heo111Hs+ykc+qKVSTqVZSlKWbk23JvrbA7dyg9PVON44DDSnu52tLVj2qEbtrtaNB0n6V9LV27Yjmov5tKlGKXZJpy95qMaaWxF1gJmJ5Q42o71K9Sb4ykm/FkKemMRvrVO6bXwLMRUtlvfuREAmftKtvrVf7svMslj6v01T+5LzIpQCT+0Kv0tT+5LzLo4+t9LP+7LzIqRXVYEyOkK+6tU/uy8zP8AJbE16lTp1ZuEU5NN3vfKKz733Grxm+03XktS1MPKp7Um/swVvjrFELT+nJKbp03ZLLLa3vzMTDS1VO+u/F+ZHxPSk59bT6nxPbRuAnWqRpU10pcdiS2t9QGyaN9JekcNbm8RKS9io+cg11KWa7mbbhPTji5WUoYWEv66dXVk/rxqdHviawuQt1Z1s+qGx9WZDxvIpU1d11Z7ub8X63/LiDr+i/TLRVlj8NUoJ/z6b56i+tuKUlfhZnQtDabw+LhzmFr060N7hNPVe20lti+p2Z8wYHQFalnSxC1XnquD1ZLrV2ZjQuGqYavDFUJKhXjtdNtwqRyvGdNpJxdtnftSEH0sDn2jfShSb1cRSlDdr05a67WnZruubvo3SNLEU1VoTU4PK63Pg080+pkEoAAAAAAAAAAAAAAAAMj6Qx1OhSnWrTUKcIucpydlFI49p3l69IJ8xJww15Q1NkqlvpO3J6uzNbQOiaV5cYOg3HXdWSy1aS1s/rNqPgzW8f6UJr+BglNb9fFaku5KnJe80GK/5wLixFeWukcRpOpGrONKhzaappU1OcE7XTrXu81wVrmiYvkvXTcrKr2VM326yXxN6AHNHoqrGXSpVF/ptrxje5Mw+iqs9kbdqmr92rc38BWlvk3X/p9/6HnPk1iOL7oP8DeBYQcwr4Fxk4y5y6ybdFr4u/uK09HOXq677KMn8DpwEHP8PyWqzz1lH61OsmvGBNhyLnvrR7oSfkboolypsRGgy5MVL9F3XF05xfhJfiXLkpW4+6P5joEcMy9YQQc/p8kKt85pdq8mzY4YCUMOqMWnJQcb7E5O934sy9fVj2kGpWA0avoyrSzqQajsbVmrcbrZ3kfnp0+lTnKD2XjJxbXajZ9I6ep05aju3vSV7J8c/cR8Rg6Vak3TSWtaV0uHw7AqLh9EYyrFTdd6skmtatUbs9jsS6HJRX1qtaUupK3vbZOwOK1KcabTlKMVGy32yv1I8sRVnPJuy9mP4y8gJeN0vSoxsnfVSVlsjwTZicNyijVnqSuru0c+i+Hf2mK0/BRhFL2vgv1MGB0bXM5yC5VLDaRpUdfKtKnRnDc9d2g+Ckm01vtdbzUdC43nKOtPJxvFy9qyTv4NEKnFupCcMq6nTrQk9ikpRaWWdleN+4UfXgAIAAAAAAAAAAAFGypp3pQ0q6WE5iDcZ4jXpaydnGml+8ae55xX2nwA0bljyl/aEsVVpJVcHo6nCrDDu+rjcRKq6UatRW6dGm4zlq/O1VxNZpaJo0Kt8LObpVKdOcqc42dOtvUctltqaTTy3ZXaCw8sNGVOjUnaotWWaV4X1tXLdcyU4KMc8+riyo8HG20tuWPv8SqT4+4ouKxjcuo0nJ9SaTstjauk+u2fZmTY0bbLNe/x/QmbmiGqTLlRZMUXwXj+hWz6iiIqDKVKdu0m2fV4PzPPm23dv3ARI0my+MI73fqXnsJFWheLSk13L39RBi2pKm09fpqyTd7ro6tld59QE2lhqkqcqqglTg0pTu5KDbSSlq781v3mSjyfrvC/LL3pW1tWNlJxvbWSs8u+5fSrqhoytg6/QxFatCpGm7XhTXMvWqZ9C+pKyeeaytmY9coqqw/yXnf3KvGyXSkr5x1l83b2/GKhpKXzbL2pScn3J5X+B418WorVhklkRcRjHLJKy4dXcRJN8So9KlW+bIWOxOpByW3YuF3sPdJdvvMVpytZxjuSlUfds/EgxUsJBp85JazUp79a185N2ss+LRL5NqUXUov5rjJdjyf/AM+LMVKeU01dupGF/wCm7nbxUTMaJn+/13vhUi+vVqRs/eyKzUMLx8C6rBRR6OoiHjK+WQGq8o6t5xjwTfi/0MVFEnSdTWqyfB6vhl5lMDh+cmo7FtlL2Y72wNjoUtXCU4b5uVR9jfR91vA8cJPVqQrTuo87CNrbW5XlteStCKPXFY+E6iUH0U4QilujFohU1HWglrOSUUle6TlrX785PuRFfYgAKgAAAAAAAAAABzn0768dGxr03aVHEUZvLbGUZ03F9Tc4+COjGrelHAKvojGwl82hOsu2jaqvfBAcA0VyxpL+NCUZbLxSlHt23Ml/iChVfRqx4JS6L8Gc2Ty7vItjcUdVhUTJFFXdjlFKpOPqTceybiTqemcTHZUn22T97RaOuQlaOrd222u7Xe123C5yZcqMX9M/uQ/KV/xTi/p39yH5RkzgdYuLnJv8UYv6eX3YflLXymxf08vd5Co602XXOQvlFiv8xU8Tz+W1qm2vUb4OrLzFazp3dmOv1K0Y+tJLtaRAxGmsLH161LLdrJtdyOUzwlTa4367png1bbkKjptXldhY5Qnd7MoNR8WkR546U81FvrbOdxl/0ZjRWlnStCbvSeyW+H6dQo2nWk9rt2Iqo9/aeUZ3zWx534l6ZUSaNWMdsFJ7taUtVfZi1fvfca7pzE69Wo2opKChlFRUY6vzYr6zM1c1fSc7yqLjLV8H+hNVbo9R1nO91FSrar3tbE+8k6HlJpznJybcrXb4q7XBZe4ix6MLWS1bq62zTUU8+GXxJGHxsIwUndLYktuTeXxfeZa3hllJvJCrOEM6klfh5LazAYnTcnlDoR6tve/+jHSrN8W37zTLKaVxFGp6tO0vbvZvuW3vIKqK2oujHK9vnPjLj2bDxUJPqRSyW137CD3w9S04tbFJbus2Pkxgufx1Cm1d89QV1uUqmrn1WszVpYnLVSsjduQdSUcRHEU4SvHpt2err2cVns3tgfUgOe4HlNWe2/iZ3C6bm9oGygx+HxzkTYTuBeAAAAAAsnOxCxONsBPbOeem3TcaWjp4aNSKrYlxpxjfN0oyUqr6lZat3b1jL4/TLW80TlhpOhWp6uKjGUVdpvJwfGDWafYBxKphtX1+iuva/qrf8Dy+ULYqcbdd79raaMhpWvQUmqGtJcZpZd62+CMdzv8ATHwAu5+D2wa+rU/CSfxH7vdKS7aa+KkW60Xtj4PzKakOLXbEC6VOL/mLvjL8Ey3mY/SR8J/lLXTj7a8H5Dmf6o+NviBesMt04fea+KDwz4w/uQ/FlnM9cfvLzHMPqfZJMCtSg45NW39q4p711lqiz2p1ZQ6NtaPstXV+K3p9asyRClCfqPVl7EnZ/Zlsl2ZPtAphMe45VM17W9dvEkYrDKa1otNPetj/AFPCWGmsnCT+w/IpSjODvBSjfbZPPuJ2dPlnV9vPvKFKLWTKwlbJ5p7vx+BLqxqT9bWf2CxYGXBpcWrJdreRWNn4yOhNIajVKTvB+rL2XwZsiZpkNSGzpy4tdFdkXt7X4F88RUltcn3sqNrq4qEfWkl3r4GuOV5Sl/Vr58E9b8CG09+Xa0elKeduKsQekW9SmpXs+dT452bfbk/EoqMehF2atKbzyu7WzPTDwvPproq6tfbCzVl23uRcVKVarJwi5XdkktwFleEE8ndcE9nVc8ud4JL3s2jQ/IupUtKs3BeylmbpojkjRp2caab9p5v3gcxwWhMRW9SnJr2pZL3mxaP9H1aVnUlbqj5vyOrYPRdt3uM1hNG9QGg6G5EwppdG74yzZtmC0DbcbXhdG9RlKGEitwGu4TQvUZnDaKS3GUgktiL7geNLDKJ7gAAAAAAFk6dyDicBrbDIgDUsfoKT3Gn6d5H86mpxuvgddLJU09qQHzFpT0a1YtulLLhKL+KMHiORmJh7L8fI+sK2jactsUY/EcmaUt3uA+SsToavD1qb7VmQpRayaa7VY+rcTyGpy2WMTi/RtCXzYvuQHzOD6AxHokpv+VHuRjq/oghuh4N+YHELCx2Cr6IlujL7zIVf0Sy3Oa94HM4YppWtF9bTv7mVeK/oh4PzN6reijEr1Zrvg/wI0vRdjPah4SA09Y1rZGP+78xctIy4Lxn+Y2v/APMcZxh/u8iq9GGM4w/3eQGq/tKfBeM/zFk9ITe6P3b/ABubjD0WYt7ZwXdIlUPRPXfrVfCHmwNAeKm/neCS+B5ym3tb8WdVw3olXz5Tl3pfBGZwfowox/lJ9t38QOI0qEpeqm+wyWE0Fip+rRl2uyS8TvOE5ERjsgl2IytDkqluA45ovkbWlZ15pLbqQV2+2T8jc8BoFRVoxS7joFHk6luJ1HQiW4DTMLol8DL4XRj4G0UtGJbiXTwqQGDwuj3wMnRw1txkIxsVAjxieiiegAtSLgAAAAAAAAAAAAAAAAAAAAAAClijguC8AALXRjwXgWvCw9lFQBb8jh7KKfIoeygAHyKHAr8khwAAqsNHgVVCPAAC5UlwK6iAArYqAAAAAAAAAAAAAAAf/9k=", "mercedes benz"))
        mylist.add(SearchRecModelim("https://a.d-cd.net/19028eas-960.jpg", "Lambarguni"))
        mylist.add(
            SearchRecModelim(
                "https://imageio.forbes.com/specials-images/imageserve/5f962df3991e5636a2f68758/0x0.jpg?format=jpg&crop=812,457,x89,y103,safe&width=1200",
                "Bugatti"
            )
        )
        mylist.add(
            SearchRecModelim(
                "https://www.autocar.co.uk/sites/autocar.co.uk/files/range-rover-2022-001-tracking-front.jpg",
                "Range Rover"
            )
        )
        mylist.add(
            SearchRecModelim(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRg-S_zB4VmK-uWlXlocl3SfpO1vCDo0vQZmg&usqp=CAU",
                "Ferari"
            )
        )
        mylist.add(
            SearchRecModelim(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9snJ2dmETQdEhPWclSCzcNPA5yFbW3NQRRA&usqp=CAU",
                "Aurus"
            )
        )
        mylist.add(SearchRecModelim("https://a.d-cd.net/d0AAAgFFieA-960.jpg", "Captiva"))
        mylist.add(
            SearchRecModelim(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfbiT62pHm3JxE-zpD2vb5dONGyD5Xw6xGFQ&usqp=CAU",
                "Bentliy"
            )
        )
        return mylist
    }
}