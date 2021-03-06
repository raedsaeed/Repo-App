package com.example.unioncoop


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.unioncoop.base.AbstractViewHolder
import com.example.unioncoop.base.TypeFactory
import com.example.unioncoop.databinding.ItemRepoBinding
import com.example.unioncoop.objects.BaseObject
import com.example.unioncoop.objects.Repo

/**
 * Created by Raed Saeed on 01/10/2020.
 */
class RepoAdapter : RecyclerView.Adapter<AbstractViewHolder<BaseObject>>() {
    private val typeFactory: TypeFactory = object : TypeFactory {
        override fun type(baseObject: BaseObject?): Int {
            return R.layout.item_repo
        }

        override fun createViewHolder(
            viewDataBinding: ViewDataBinding?,
            type: Int
        ): AbstractViewHolder<*> {
            return RepoViewHolder(viewDataBinding!!)
        }
    }

    private var items: MutableList<Repo>? = null
    private var previousSelectedPosition = -1

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder<BaseObject> {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
        return typeFactory.createViewHolder(binding, viewType) as AbstractViewHolder<BaseObject>
    }

    override fun onBindViewHolder(holder: AbstractViewHolder<BaseObject>, position: Int) {
        val element: BaseObject = items!![position]
        holder.bind(element)
    }

    override fun getItemCount(): Int {
        return if (items == null) 0 else items?.size!!
    }

    override fun getItemViewType(position: Int): Int {
        return typeFactory.type(items!![position])
    }

    fun setItems(list: MutableList<Repo>) {
        items = list
        notifyDataSetChanged()
    }

    fun clear() {
        if (items != null) {
            items!!.clear()
            notifyDataSetChanged()
        }
    }


    private fun selectItem(select: Boolean, repo: Repo, position: Int) {
        repo.isSelected = select
        items!![position] = repo
        notifyItemChanged(position)
    }

    internal inner class RepoViewHolder(viewBinding: ViewDataBinding) :
        AbstractViewHolder<Repo>(viewBinding.root), View.OnClickListener {
        private val binding = viewBinding as ItemRepoBinding
        private val requestManager: RequestManager = Glide.with(itemView)

        init {
            binding.cvItemRepoCard.setOnClickListener(this)
            binding.ivItemRepoAvatar.setOnClickListener(this)
        }

        override fun bind(element: Repo) {
            binding.tvItemRepoName.text = element.name
            binding.tvItemRepoAuthor.text = element.author
            binding.tvItemRepoDescription.text = element.description
            binding.tvItemRepoLang.text = element.language
            binding.tvItemRepoStarCount.text = element.stars.toString()
            binding.tvItemRepoStarFork.text = element.forks.toString()

            requestManager.load(element.avatar)
                .into(binding.ivItemRepoAvatar)

            binding.clItemRepoDescriptionContainer.visibility =
                if (element.isSelected) View.VISIBLE else View.GONE

        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition
            if (previousSelectedPosition != position) {
                selectItem(true, items?.get(position)!!, position)
                if (previousSelectedPosition != -1) {
                    selectItem(false, items!![previousSelectedPosition], previousSelectedPosition)
                }
                previousSelectedPosition = position
            } else if (previousSelectedPosition != -1) {
                selectItem(false, items!![previousSelectedPosition], previousSelectedPosition)
                previousSelectedPosition = -1
            }
        }

    }
}